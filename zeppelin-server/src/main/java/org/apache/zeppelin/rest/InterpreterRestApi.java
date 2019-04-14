/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zeppelin.rest;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.zeppelin.Repository;
import org.apache.zeppelin.Repository.ProxyProtocol;
import org.apache.zeppelin.storage.InterpreterOptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.zeppelin.core.configuration.interpreter.BaseInterpreterConfig;
import ru.tinkoff.zeppelin.core.configuration.interpreter.InterpreterArtifactSource;
import ru.tinkoff.zeppelin.core.configuration.interpreter.InterpreterOption;
import ru.tinkoff.zeppelin.core.configuration.interpreter.InterpreterProperty;
import ru.tinkoff.zeppelin.engine.server.InterpreterInstaller;


/**
 * Interpreter Rest API.
 */
@RestController
@RequestMapping("/api/interpreter")
public class InterpreterRestApi {

  private static final Logger logger = LoggerFactory.getLogger(InterpreterRestApi.class);

  private final InterpreterOptionRepository interpreterOptionRepository;

  @Autowired
  public InterpreterRestApi(final InterpreterOptionRepository interpreterOptionRepository) {
    this.interpreterOptionRepository = interpreterOptionRepository;

    try {
      tempRepositoryInit();
    } catch (final Exception e) {
      logger.error("Failed to init interpreter settings", e);
    }
  }

  /**
   * Initialize interpreter settings
   */
  private void tempRepositoryInit() {
    interpreterOptionRepository.saveRepository(
        new Repository(true, "central", "http://repo1.maven.org/maven2/",
            "username", "password", ProxyProtocol.HTTP, "127.0.0.1",
            8000, "proxyLogin", "proxyPass"));

  }

  /**
   * List of dependency resolving repositories.
   */
  @GetMapping(value = "/repository", produces = "application/json")
  public ResponseEntity listRepositories() {
    try {
      return new JsonResponse<>(HttpStatus.OK, "", interpreterOptionRepository.getAllRepositories()).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while loading all repositories ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Add new repository.
   *
   * @param message Repository
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @PostMapping(value = "/repository", produces = "application/json")
  public ResponseEntity addRepository(@RequestBody final String message) {
    try {
      final Repository request = Repository.fromJson(message);
      interpreterOptionRepository.saveRepository(request);
      logger.info("New repository {} added", request.getId());
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while creating repository ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Delete repository.
   *
   * @param repoId ID of repository
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @DeleteMapping(value = "/repository/{repoId}", produces = "application/json")
  public ResponseEntity removeRepository(@PathVariable("repoId") final String repoId) {
    try {
      logger.info("Remove repository {}", repoId);
      interpreterOptionRepository.removeRepository(repoId);
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while deleting repository ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * List of all sources.
   */
  @GetMapping(value = "/source", produces = "application/json")
  public ResponseEntity listSources() {
    try {
      return new JsonResponse<>(HttpStatus.OK, "", interpreterOptionRepository.getAllSources()).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while loading all sources ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Add new source.
   *
   * @param message InterpreterArtifactSource
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @PostMapping(value = "/source", produces = "application/json")
  public ResponseEntity addSource(@RequestBody final String message) {
    try {
      final InterpreterArtifactSource request = InterpreterArtifactSource.fromJson(message);
      // install sources
      final InterpreterInstaller interpreterInstaller = new InterpreterInstaller();
      final String installationDir = interpreterInstaller.install(
              request.getInterpreterName(),
              request.getArtifact(),
              interpreterOptionRepository.getAllRepositories()
      );
      if (!StringUtils.isAllBlank(installationDir)) {
        request.setPath(installationDir);
        request.setStatus(InterpreterArtifactSource.Status.INSTALLED);
      } else {
        request.setStatus(InterpreterArtifactSource.Status.NOT_INSTALLED);
      }
      interpreterOptionRepository.saveSource(request);

      logger.info("New source {} added", request.getInterpreterName());
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while creating new source ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Delete source.
   *
   * @param interpreterName of interpreter
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @DeleteMapping(value = "/source/{name}", produces = "application/json")
  public ResponseEntity removeSource(@PathVariable("name") final String interpreterName) {
    try {
      logger.info("Remove source {}", interpreterName);
      final InterpreterArtifactSource source = interpreterOptionRepository.getSource(interpreterName);
      Preconditions.checkNotNull(source);
      InterpreterInstaller.uninstallInterpreter(source.getInterpreterName());

      interpreterOptionRepository.removeSource(interpreterName);
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while deleting source ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * List all interpreter settings.
   */
  @GetMapping(value = "/setting", produces = "application/json")
  public ResponseEntity listSettings() {
    try {
      return new JsonResponse<>(HttpStatus.OK, "", interpreterOptionRepository.getAllOptions()).build();
    } catch (final Exception e) {
      logger.error("Fail to get all interpreter setting", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Get a setting.
   */
  @GetMapping(value = "/setting/{shebang}", produces = "application/json")
  public ResponseEntity getSetting(@PathVariable("shebang") final String shebang) {
    try {
      final InterpreterOption setting = interpreterOptionRepository.getOption(shebang);
      if (setting == null) {
        return new JsonResponse<>(HttpStatus.NOT_FOUND).build();
      } else {
        return new JsonResponse<>(HttpStatus.OK, "", setting).build();
      }
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while creating ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Add new interpreter setting.
   *
   * @param message NewInterpreterSettingRequest
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @PostMapping(value = "/setting", produces = "application/json")
  public ResponseEntity newSettings(@RequestBody final String message) {
    logger.info("Trying to add option via msg: {}", message);
    if (message == null) {
      return new JsonResponse(HttpStatus.BAD_REQUEST).build();
    }
    try {
      final InterpreterOption option = new Gson().fromJson(message, InterpreterOption.class);
      logger.info("Trying to add option: {}", option);
      interpreterOptionRepository.saveOption(option);
      logger.info("New option {} added", option.getShebang());
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while creating option ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
          ExceptionUtils.getStackTrace(e)).build();
    }
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @PutMapping(value = "/setting/{shebang}", produces = "application/json")
  public ResponseEntity updateSetting(@RequestBody final String message, @PathVariable("shebang") final String shebang) {
    logger.info("Update interpreterSetting {}", shebang);
    if (message == null) {
      return new JsonResponse(HttpStatus.BAD_REQUEST).build();
    }
    try {
      final InterpreterOption option = new Gson().fromJson(message, InterpreterOption.class);
      interpreterOptionRepository.updateOption(option);
      logger.info("Option {} updated", option.getShebang());
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while creating option ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
          ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Remove interpreter setting.
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @DeleteMapping(value = "/setting/{shebang}", produces = "application/json")
  public ResponseEntity removeSetting(@PathVariable("shebang") final String shebang) {
    try {
      logger.info("Remove interpreterSetting {}", "%" + shebang);
      interpreterOptionRepository.removeOption("%" + shebang);
      return new JsonResponse(HttpStatus.OK).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while removing interpreter option ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
              ExceptionUtils.getStackTrace(e)).build();
    }
  }

  /**
   * Restart interpreter setting.
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @PutMapping(value = "/setting/restart/{settingId}", produces = "application/json")
  public ResponseEntity restartSetting(@RequestBody final String message, @PathVariable("settingId") final String settingId) {
    logger.info("Restart interpreterSetting {}, msg={}", settingId, message);

    //    final InterpreterSetting setting = interpreterSettingManager.get(settingId);
    //    try {
    //      final RestartInterpreterRequest request = RestartInterpreterRequest.fromJson(message);
    //
    //      final String noteId = request == null ? null : request.getUuid();
    //      if (null == noteId) {
    //        interpreterSettingManager.close(settingId);
    //      } else {
    //        interpreterSettingManager.restart(settingId, noteId, securityService.getPrincipal());
    //      }
    //
    //    } catch (final InterpreterException e) {
    //      logger.error("Exception in InterpreterRestApi while restartSetting ", e);
    //      return new JsonResponse(HttpStatus.NOT_FOUND, e.getMessage(), ExceptionUtils.getStackTrace(e))
    //          .build();
    //    }
    //    if (setting == null) {
    //      return new JsonResponse(HttpStatus.NOT_FOUND, "", settingId).build();
    //    }
    //    return new JsonResponse(HttpStatus.OK, "", setting).build();
    return new JsonResponse<>(HttpStatus.NOT_IMPLEMENTED, "").build();
  }

  /**
   * List all available interpreters by group.
   */
  @GetMapping(produces = "application/json")
  public ResponseEntity listInterpreter() {
    try {
      final Map<String, BaseInterpreterConfig> m = new HashMap<>();
      final List<InterpreterArtifactSource> sources= interpreterOptionRepository.getAllSources();
      for (final InterpreterArtifactSource source: sources) {
        final List<BaseInterpreterConfig> configList =
            InterpreterInstaller.getDefaultConfig(source.getInterpreterName());
        if (!configList.isEmpty()) {
          m.put(source.getInterpreterName(), configList.get(0));
        }
      }
      return new JsonResponse<>(HttpStatus.OK, "", m).build();
    } catch (final Exception e) {
      logger.error("Exception in InterpreterRestApi while loading all options ", e);
      return new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),
          ExceptionUtils.getStackTrace(e)).build();
    }
  }


  /**
   * Get available types for property
   */
  @GetMapping(value = "/property/types", produces = "application/json")
  public ResponseEntity listInterpreterPropertyTypes() {
    return new JsonResponse<>(HttpStatus.OK, InterpreterProperty.getTypes()).build();
  }
}
