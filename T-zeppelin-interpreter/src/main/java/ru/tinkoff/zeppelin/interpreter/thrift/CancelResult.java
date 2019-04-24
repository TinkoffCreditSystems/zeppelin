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
public class CancelResult implements org.apache.thrift.TBase<CancelResult, CancelResult._Fields>, java.io.Serializable, Cloneable, Comparable<CancelResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CancelResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField INTERPRETER_JOB_UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("interpreterJobUUID", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("uuid", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CancelResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CancelResultTupleSchemeFactory();

  /**
   * 
   * @see CancelResultStatus
   */
  public CancelResultStatus status; // required
  public java.lang.String interpreterJobUUID; // required
  public java.lang.String uuid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see CancelResultStatus
     */
    STATUS((short)1, "status"),
    INTERPRETER_JOB_UUID((short)2, "interpreterJobUUID"),
    UUID((short)3, "uuid");

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
        case 1: // STATUS
          return STATUS;
        case 2: // INTERPRETER_JOB_UUID
          return INTERPRETER_JOB_UUID;
        case 3: // UUID
          return UUID;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, CancelResultStatus.class)));
    tmpMap.put(_Fields.INTERPRETER_JOB_UUID, new org.apache.thrift.meta_data.FieldMetaData("interpreterJobUUID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.UUID, new org.apache.thrift.meta_data.FieldMetaData("uuid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CancelResult.class, metaDataMap);
  }

  public CancelResult() {
  }

  public CancelResult(
    CancelResultStatus status,
    java.lang.String interpreterJobUUID,
    java.lang.String uuid)
  {
    this();
    this.status = status;
    this.interpreterJobUUID = interpreterJobUUID;
    this.uuid = uuid;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CancelResult(CancelResult other) {
    if (other.isSetStatus()) {
      this.status = other.status;
    }
    if (other.isSetInterpreterJobUUID()) {
      this.interpreterJobUUID = other.interpreterJobUUID;
    }
    if (other.isSetUuid()) {
      this.uuid = other.uuid;
    }
  }

  public CancelResult deepCopy() {
    return new CancelResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.interpreterJobUUID = null;
    this.uuid = null;
  }

  /**
   * 
   * @see CancelResultStatus
   */
  public CancelResultStatus getStatus() {
    return this.status;
  }

  /**
   * 
   * @see CancelResultStatus
   */
  public CancelResult setStatus(CancelResultStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public java.lang.String getInterpreterJobUUID() {
    return this.interpreterJobUUID;
  }

  public CancelResult setInterpreterJobUUID(java.lang.String interpreterJobUUID) {
    this.interpreterJobUUID = interpreterJobUUID;
    return this;
  }

  public void unsetInterpreterJobUUID() {
    this.interpreterJobUUID = null;
  }

  /** Returns true if field interpreterJobUUID is set (has been assigned a value) and false otherwise */
  public boolean isSetInterpreterJobUUID() {
    return this.interpreterJobUUID != null;
  }

  public void setInterpreterJobUUIDIsSet(boolean value) {
    if (!value) {
      this.interpreterJobUUID = null;
    }
  }

  public java.lang.String getUuid() {
    return this.uuid;
  }

  public CancelResult setUuid(java.lang.String uuid) {
    this.uuid = uuid;
    return this;
  }

  public void unsetUuid() {
    this.uuid = null;
  }

  /** Returns true if field uuid is set (has been assigned a value) and false otherwise */
  public boolean isSetUuid() {
    return this.uuid != null;
  }

  public void setUuidIsSet(boolean value) {
    if (!value) {
      this.uuid = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((CancelResultStatus)value);
      }
      break;

    case INTERPRETER_JOB_UUID:
      if (value == null) {
        unsetInterpreterJobUUID();
      } else {
        setInterpreterJobUUID((java.lang.String)value);
      }
      break;

    case UUID:
      if (value == null) {
        unsetUuid();
      } else {
        setUuid((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case INTERPRETER_JOB_UUID:
      return getInterpreterJobUUID();

    case UUID:
      return getUuid();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case INTERPRETER_JOB_UUID:
      return isSetInterpreterJobUUID();
    case UUID:
      return isSetUuid();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof CancelResult)
      return this.equals((CancelResult)that);
    return false;
  }

  public boolean equals(CancelResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_interpreterJobUUID = true && this.isSetInterpreterJobUUID();
    boolean that_present_interpreterJobUUID = true && that.isSetInterpreterJobUUID();
    if (this_present_interpreterJobUUID || that_present_interpreterJobUUID) {
      if (!(this_present_interpreterJobUUID && that_present_interpreterJobUUID))
        return false;
      if (!this.interpreterJobUUID.equals(that.interpreterJobUUID))
        return false;
    }

    boolean this_present_uuid = true && this.isSetUuid();
    boolean that_present_uuid = true && that.isSetUuid();
    if (this_present_uuid || that_present_uuid) {
      if (!(this_present_uuid && that_present_uuid))
        return false;
      if (!this.uuid.equals(that.uuid))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatus()) ? 131071 : 524287);
    if (isSetStatus())
      hashCode = hashCode * 8191 + status.getValue();

    hashCode = hashCode * 8191 + ((isSetInterpreterJobUUID()) ? 131071 : 524287);
    if (isSetInterpreterJobUUID())
      hashCode = hashCode * 8191 + interpreterJobUUID.hashCode();

    hashCode = hashCode * 8191 + ((isSetUuid()) ? 131071 : 524287);
    if (isSetUuid())
      hashCode = hashCode * 8191 + uuid.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(CancelResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInterpreterJobUUID()).compareTo(other.isSetInterpreterJobUUID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInterpreterJobUUID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.interpreterJobUUID, other.interpreterJobUUID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUuid()).compareTo(other.isSetUuid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUuid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uuid, other.uuid);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("CancelResult(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("interpreterJobUUID:");
    if (this.interpreterJobUUID == null) {
      sb.append("null");
    } else {
      sb.append(this.interpreterJobUUID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("uuid:");
    if (this.uuid == null) {
      sb.append("null");
    } else {
      sb.append(this.uuid);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CancelResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CancelResultStandardScheme getScheme() {
      return new CancelResultStandardScheme();
    }
  }

  private static class CancelResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<CancelResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CancelResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = ru.tinkoff.zeppelin.interpreter.thrift.CancelResultStatus.findByValue(iprot.readI32());
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INTERPRETER_JOB_UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.interpreterJobUUID = iprot.readString();
              struct.setInterpreterJobUUIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.uuid = iprot.readString();
              struct.setUuidIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CancelResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        oprot.writeI32(struct.status.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.interpreterJobUUID != null) {
        oprot.writeFieldBegin(INTERPRETER_JOB_UUID_FIELD_DESC);
        oprot.writeString(struct.interpreterJobUUID);
        oprot.writeFieldEnd();
      }
      if (struct.uuid != null) {
        oprot.writeFieldBegin(UUID_FIELD_DESC);
        oprot.writeString(struct.uuid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CancelResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CancelResultTupleScheme getScheme() {
      return new CancelResultTupleScheme();
    }
  }

  private static class CancelResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<CancelResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CancelResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetInterpreterJobUUID()) {
        optionals.set(1);
      }
      if (struct.isSetUuid()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.status.getValue());
      }
      if (struct.isSetInterpreterJobUUID()) {
        oprot.writeString(struct.interpreterJobUUID);
      }
      if (struct.isSetUuid()) {
        oprot.writeString(struct.uuid);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CancelResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.status = ru.tinkoff.zeppelin.interpreter.thrift.CancelResultStatus.findByValue(iprot.readI32());
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        struct.interpreterJobUUID = iprot.readString();
        struct.setInterpreterJobUUIDIsSet(true);
      }
      if (incoming.get(2)) {
        struct.uuid = iprot.readString();
        struct.setUuidIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

