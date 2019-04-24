/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ru.tinkoff.zeppelin.interpreter.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-04-23")
public class RegisterInfo implements org.apache.thrift.TBase<RegisterInfo, RegisterInfo._Fields>, java.io.Serializable, Cloneable, Comparable<RegisterInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RegisterInfo");

  private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("port", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SHEBANG_FIELD_DESC = new org.apache.thrift.protocol.TField("shebang", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PROCESS_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("processType", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PROCESS_UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("processUUID", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RegisterInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RegisterInfoTupleSchemeFactory();

  public java.lang.String host; // required
  public int port; // required
  public java.lang.String shebang; // required
  public java.lang.String processType; // required
  public java.lang.String processUUID; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HOST((short)1, "host"),
    PORT((short)2, "port"),
    SHEBANG((short)3, "shebang"),
    PROCESS_TYPE((short)4, "processType"),
    PROCESS_UUID((short)5, "processUUID");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HOST
          return HOST;
        case 2: // PORT
          return PORT;
        case 3: // SHEBANG
          return SHEBANG;
        case 4: // PROCESS_TYPE
          return PROCESS_TYPE;
        case 5: // PROCESS_UUID
          return PROCESS_UUID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PORT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PORT, new org.apache.thrift.meta_data.FieldMetaData("port", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SHEBANG, new org.apache.thrift.meta_data.FieldMetaData("shebang", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROCESS_TYPE, new org.apache.thrift.meta_data.FieldMetaData("processType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROCESS_UUID, new org.apache.thrift.meta_data.FieldMetaData("processUUID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RegisterInfo.class, metaDataMap);
  }

  public RegisterInfo() {
  }

  public RegisterInfo(
    java.lang.String host,
    int port,
    java.lang.String shebang,
    java.lang.String processType,
    java.lang.String processUUID)
  {
    this();
    this.host = host;
    this.port = port;
    setPortIsSet(true);
    this.shebang = shebang;
    this.processType = processType;
    this.processUUID = processUUID;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RegisterInfo(RegisterInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHost()) {
      this.host = other.host;
    }
    this.port = other.port;
    if (other.isSetShebang()) {
      this.shebang = other.shebang;
    }
    if (other.isSetProcessType()) {
      this.processType = other.processType;
    }
    if (other.isSetProcessUUID()) {
      this.processUUID = other.processUUID;
    }
  }

  public RegisterInfo deepCopy() {
    return new RegisterInfo(this);
  }

  @Override
  public void clear() {
    this.host = null;
    setPortIsSet(false);
    this.port = 0;
    this.shebang = null;
    this.processType = null;
    this.processUUID = null;
  }

  public java.lang.String getHost() {
    return this.host;
  }

  public RegisterInfo setHost(java.lang.String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been assigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  public int getPort() {
    return this.port;
  }

  public RegisterInfo setPort(int port) {
    this.port = port;
    setPortIsSet(true);
    return this;
  }

  public void unsetPort() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  /** Returns true if field port is set (has been assigned a value) and false otherwise */
  public boolean isSetPort() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  public void setPortIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PORT_ISSET_ID, value);
  }

  public java.lang.String getShebang() {
    return this.shebang;
  }

  public RegisterInfo setShebang(java.lang.String shebang) {
    this.shebang = shebang;
    return this;
  }

  public void unsetShebang() {
    this.shebang = null;
  }

  /** Returns true if field shebang is set (has been assigned a value) and false otherwise */
  public boolean isSetShebang() {
    return this.shebang != null;
  }

  public void setShebangIsSet(boolean value) {
    if (!value) {
      this.shebang = null;
    }
  }

  public java.lang.String getProcessType() {
    return this.processType;
  }

  public RegisterInfo setProcessType(java.lang.String processType) {
    this.processType = processType;
    return this;
  }

  public void unsetProcessType() {
    this.processType = null;
  }

  /** Returns true if field processType is set (has been assigned a value) and false otherwise */
  public boolean isSetProcessType() {
    return this.processType != null;
  }

  public void setProcessTypeIsSet(boolean value) {
    if (!value) {
      this.processType = null;
    }
  }

  public java.lang.String getProcessUUID() {
    return this.processUUID;
  }

  public RegisterInfo setProcessUUID(java.lang.String processUUID) {
    this.processUUID = processUUID;
    return this;
  }

  public void unsetProcessUUID() {
    this.processUUID = null;
  }

  /** Returns true if field processUUID is set (has been assigned a value) and false otherwise */
  public boolean isSetProcessUUID() {
    return this.processUUID != null;
  }

  public void setProcessUUIDIsSet(boolean value) {
    if (!value) {
      this.processUUID = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((java.lang.String)value);
      }
      break;

    case PORT:
      if (value == null) {
        unsetPort();
      } else {
        setPort((java.lang.Integer)value);
      }
      break;

    case SHEBANG:
      if (value == null) {
        unsetShebang();
      } else {
        setShebang((java.lang.String)value);
      }
      break;

    case PROCESS_TYPE:
      if (value == null) {
        unsetProcessType();
      } else {
        setProcessType((java.lang.String)value);
      }
      break;

    case PROCESS_UUID:
      if (value == null) {
        unsetProcessUUID();
      } else {
        setProcessUUID((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case HOST:
      return getHost();

    case PORT:
      return getPort();

    case SHEBANG:
      return getShebang();

    case PROCESS_TYPE:
      return getProcessType();

    case PROCESS_UUID:
      return getProcessUUID();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case HOST:
      return isSetHost();
    case PORT:
      return isSetPort();
    case SHEBANG:
      return isSetShebang();
    case PROCESS_TYPE:
      return isSetProcessType();
    case PROCESS_UUID:
      return isSetProcessUUID();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RegisterInfo)
      return this.equals((RegisterInfo)that);
    return false;
  }

  public boolean equals(RegisterInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_port = true;
    boolean that_present_port = true;
    if (this_present_port || that_present_port) {
      if (!(this_present_port && that_present_port))
        return false;
      if (this.port != that.port)
        return false;
    }

    boolean this_present_shebang = true && this.isSetShebang();
    boolean that_present_shebang = true && that.isSetShebang();
    if (this_present_shebang || that_present_shebang) {
      if (!(this_present_shebang && that_present_shebang))
        return false;
      if (!this.shebang.equals(that.shebang))
        return false;
    }

    boolean this_present_processType = true && this.isSetProcessType();
    boolean that_present_processType = true && that.isSetProcessType();
    if (this_present_processType || that_present_processType) {
      if (!(this_present_processType && that_present_processType))
        return false;
      if (!this.processType.equals(that.processType))
        return false;
    }

    boolean this_present_processUUID = true && this.isSetProcessUUID();
    boolean that_present_processUUID = true && that.isSetProcessUUID();
    if (this_present_processUUID || that_present_processUUID) {
      if (!(this_present_processUUID && that_present_processUUID))
        return false;
      if (!this.processUUID.equals(that.processUUID))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetHost()) ? 131071 : 524287);
    if (isSetHost())
      hashCode = hashCode * 8191 + host.hashCode();

    hashCode = hashCode * 8191 + port;

    hashCode = hashCode * 8191 + ((isSetShebang()) ? 131071 : 524287);
    if (isSetShebang())
      hashCode = hashCode * 8191 + shebang.hashCode();

    hashCode = hashCode * 8191 + ((isSetProcessType()) ? 131071 : 524287);
    if (isSetProcessType())
      hashCode = hashCode * 8191 + processType.hashCode();

    hashCode = hashCode * 8191 + ((isSetProcessUUID()) ? 131071 : 524287);
    if (isSetProcessUUID())
      hashCode = hashCode * 8191 + processUUID.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RegisterInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetHost()).compareTo(other.isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, other.host);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPort()).compareTo(other.isSetPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.port, other.port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetShebang()).compareTo(other.isSetShebang());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShebang()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.shebang, other.shebang);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProcessType()).compareTo(other.isSetProcessType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProcessType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processType, other.processType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProcessUUID()).compareTo(other.isSetProcessUUID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProcessUUID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processUUID, other.processUUID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RegisterInfo(");
    boolean first = true;

    sb.append("host:");
    if (this.host == null) {
      sb.append("null");
    } else {
      sb.append(this.host);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("port:");
    sb.append(this.port);
    first = false;
    if (!first) sb.append(", ");
    sb.append("shebang:");
    if (this.shebang == null) {
      sb.append("null");
    } else {
      sb.append(this.shebang);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("processType:");
    if (this.processType == null) {
      sb.append("null");
    } else {
      sb.append(this.processType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("processUUID:");
    if (this.processUUID == null) {
      sb.append("null");
    } else {
      sb.append(this.processUUID);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RegisterInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RegisterInfoStandardScheme getScheme() {
      return new RegisterInfoStandardScheme();
    }
  }

  private static class RegisterInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<RegisterInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RegisterInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // HOST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.host = iprot.readString();
              struct.setHostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.port = iprot.readI32();
              struct.setPortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SHEBANG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.shebang = iprot.readString();
              struct.setShebangIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PROCESS_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.processType = iprot.readString();
              struct.setProcessTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PROCESS_UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.processUUID = iprot.readString();
              struct.setProcessUUIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RegisterInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.host != null) {
        oprot.writeFieldBegin(HOST_FIELD_DESC);
        oprot.writeString(struct.host);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PORT_FIELD_DESC);
      oprot.writeI32(struct.port);
      oprot.writeFieldEnd();
      if (struct.shebang != null) {
        oprot.writeFieldBegin(SHEBANG_FIELD_DESC);
        oprot.writeString(struct.shebang);
        oprot.writeFieldEnd();
      }
      if (struct.processType != null) {
        oprot.writeFieldBegin(PROCESS_TYPE_FIELD_DESC);
        oprot.writeString(struct.processType);
        oprot.writeFieldEnd();
      }
      if (struct.processUUID != null) {
        oprot.writeFieldBegin(PROCESS_UUID_FIELD_DESC);
        oprot.writeString(struct.processUUID);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RegisterInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RegisterInfoTupleScheme getScheme() {
      return new RegisterInfoTupleScheme();
    }
  }

  private static class RegisterInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<RegisterInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RegisterInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetHost()) {
        optionals.set(0);
      }
      if (struct.isSetPort()) {
        optionals.set(1);
      }
      if (struct.isSetShebang()) {
        optionals.set(2);
      }
      if (struct.isSetProcessType()) {
        optionals.set(3);
      }
      if (struct.isSetProcessUUID()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetHost()) {
        oprot.writeString(struct.host);
      }
      if (struct.isSetPort()) {
        oprot.writeI32(struct.port);
      }
      if (struct.isSetShebang()) {
        oprot.writeString(struct.shebang);
      }
      if (struct.isSetProcessType()) {
        oprot.writeString(struct.processType);
      }
      if (struct.isSetProcessUUID()) {
        oprot.writeString(struct.processUUID);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RegisterInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.host = iprot.readString();
        struct.setHostIsSet(true);
      }
      if (incoming.get(1)) {
        struct.port = iprot.readI32();
        struct.setPortIsSet(true);
      }
      if (incoming.get(2)) {
        struct.shebang = iprot.readString();
        struct.setShebangIsSet(true);
      }
      if (incoming.get(3)) {
        struct.processType = iprot.readString();
        struct.setProcessTypeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.processUUID = iprot.readString();
        struct.setProcessUUIDIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

