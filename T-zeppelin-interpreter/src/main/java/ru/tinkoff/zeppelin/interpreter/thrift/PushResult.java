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
public class PushResult implements org.apache.thrift.TBase<PushResult, PushResult._Fields>, java.io.Serializable, Cloneable, Comparable<PushResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PushResult");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField INTERPRETER_JOB_UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("interpreterJobUUID", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField INTERPRETER_PROCESS_UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("interpreterProcessUUID", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PushResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PushResultTupleSchemeFactory();

  /**
   * 
   * @see PushResultStatus
   */
  public PushResultStatus status; // required
  public java.lang.String interpreterJobUUID; // required
  public java.lang.String interpreterProcessUUID; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see PushResultStatus
     */
    STATUS((short)1, "status"),
    INTERPRETER_JOB_UUID((short)2, "interpreterJobUUID"),
    INTERPRETER_PROCESS_UUID((short)3, "interpreterProcessUUID");

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
        case 3: // INTERPRETER_PROCESS_UUID
          return INTERPRETER_PROCESS_UUID;
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
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PushResultStatus.class)));
    tmpMap.put(_Fields.INTERPRETER_JOB_UUID, new org.apache.thrift.meta_data.FieldMetaData("interpreterJobUUID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INTERPRETER_PROCESS_UUID, new org.apache.thrift.meta_data.FieldMetaData("interpreterProcessUUID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PushResult.class, metaDataMap);
  }

  public PushResult() {
  }

  public PushResult(
    PushResultStatus status,
    java.lang.String interpreterJobUUID,
    java.lang.String interpreterProcessUUID)
  {
    this();
    this.status = status;
    this.interpreterJobUUID = interpreterJobUUID;
    this.interpreterProcessUUID = interpreterProcessUUID;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PushResult(PushResult other) {
    if (other.isSetStatus()) {
      this.status = other.status;
    }
    if (other.isSetInterpreterJobUUID()) {
      this.interpreterJobUUID = other.interpreterJobUUID;
    }
    if (other.isSetInterpreterProcessUUID()) {
      this.interpreterProcessUUID = other.interpreterProcessUUID;
    }
  }

  public PushResult deepCopy() {
    return new PushResult(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.interpreterJobUUID = null;
    this.interpreterProcessUUID = null;
  }

  /**
   * 
   * @see PushResultStatus
   */
  public PushResultStatus getStatus() {
    return this.status;
  }

  /**
   * 
   * @see PushResultStatus
   */
  public PushResult setStatus(PushResultStatus status) {
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

  public PushResult setInterpreterJobUUID(java.lang.String interpreterJobUUID) {
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

  public java.lang.String getInterpreterProcessUUID() {
    return this.interpreterProcessUUID;
  }

  public PushResult setInterpreterProcessUUID(java.lang.String interpreterProcessUUID) {
    this.interpreterProcessUUID = interpreterProcessUUID;
    return this;
  }

  public void unsetInterpreterProcessUUID() {
    this.interpreterProcessUUID = null;
  }

  /** Returns true if field interpreterProcessUUID is set (has been assigned a value) and false otherwise */
  public boolean isSetInterpreterProcessUUID() {
    return this.interpreterProcessUUID != null;
  }

  public void setInterpreterProcessUUIDIsSet(boolean value) {
    if (!value) {
      this.interpreterProcessUUID = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((PushResultStatus)value);
      }
      break;

    case INTERPRETER_JOB_UUID:
      if (value == null) {
        unsetInterpreterJobUUID();
      } else {
        setInterpreterJobUUID((java.lang.String)value);
      }
      break;

    case INTERPRETER_PROCESS_UUID:
      if (value == null) {
        unsetInterpreterProcessUUID();
      } else {
        setInterpreterProcessUUID((java.lang.String)value);
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

    case INTERPRETER_PROCESS_UUID:
      return getInterpreterProcessUUID();

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
    case INTERPRETER_PROCESS_UUID:
      return isSetInterpreterProcessUUID();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof PushResult)
      return this.equals((PushResult)that);
    return false;
  }

  public boolean equals(PushResult that) {
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

    boolean this_present_interpreterProcessUUID = true && this.isSetInterpreterProcessUUID();
    boolean that_present_interpreterProcessUUID = true && that.isSetInterpreterProcessUUID();
    if (this_present_interpreterProcessUUID || that_present_interpreterProcessUUID) {
      if (!(this_present_interpreterProcessUUID && that_present_interpreterProcessUUID))
        return false;
      if (!this.interpreterProcessUUID.equals(that.interpreterProcessUUID))
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

    hashCode = hashCode * 8191 + ((isSetInterpreterProcessUUID()) ? 131071 : 524287);
    if (isSetInterpreterProcessUUID())
      hashCode = hashCode * 8191 + interpreterProcessUUID.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(PushResult other) {
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
    lastComparison = java.lang.Boolean.valueOf(isSetInterpreterProcessUUID()).compareTo(other.isSetInterpreterProcessUUID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInterpreterProcessUUID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.interpreterProcessUUID, other.interpreterProcessUUID);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("PushResult(");
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
    sb.append("interpreterProcessUUID:");
    if (this.interpreterProcessUUID == null) {
      sb.append("null");
    } else {
      sb.append(this.interpreterProcessUUID);
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

  private static class PushResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PushResultStandardScheme getScheme() {
      return new PushResultStandardScheme();
    }
  }

  private static class PushResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<PushResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PushResult struct) throws org.apache.thrift.TException {
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
              struct.status = ru.tinkoff.zeppelin.interpreter.thrift.PushResultStatus.findByValue(iprot.readI32());
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
          case 3: // INTERPRETER_PROCESS_UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.interpreterProcessUUID = iprot.readString();
              struct.setInterpreterProcessUUIDIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PushResult struct) throws org.apache.thrift.TException {
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
      if (struct.interpreterProcessUUID != null) {
        oprot.writeFieldBegin(INTERPRETER_PROCESS_UUID_FIELD_DESC);
        oprot.writeString(struct.interpreterProcessUUID);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PushResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PushResultTupleScheme getScheme() {
      return new PushResultTupleScheme();
    }
  }

  private static class PushResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<PushResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PushResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      if (struct.isSetInterpreterJobUUID()) {
        optionals.set(1);
      }
      if (struct.isSetInterpreterProcessUUID()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.status.getValue());
      }
      if (struct.isSetInterpreterJobUUID()) {
        oprot.writeString(struct.interpreterJobUUID);
      }
      if (struct.isSetInterpreterProcessUUID()) {
        oprot.writeString(struct.interpreterProcessUUID);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PushResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.status = ru.tinkoff.zeppelin.interpreter.thrift.PushResultStatus.findByValue(iprot.readI32());
        struct.setStatusIsSet(true);
      }
      if (incoming.get(1)) {
        struct.interpreterJobUUID = iprot.readString();
        struct.setInterpreterJobUUIDIsSet(true);
      }
      if (incoming.get(2)) {
        struct.interpreterProcessUUID = iprot.readString();
        struct.setInterpreterProcessUUIDIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

