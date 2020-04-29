/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package Effekseer.swig;

public class EffekseerEffectCore {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected EffekseerEffectCore(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffekseerEffectCore obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        EffekseerCoreJNI.delete_EffekseerEffectCore(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public EffekseerEffectCore() {
    this(EffekseerCoreJNI.new_EffekseerEffectCore(), true);
  }

  public boolean Load(byte[] data, int len, float magnification) {
    return EffekseerCoreJNI.EffekseerEffectCore_Load(swigCPtr, this, data, len, magnification);
  }

  public String GetTexturePath(int index, EffekseerTextureType type) {
    return EffekseerCoreJNI.EffekseerEffectCore_GetTexturePath(swigCPtr, this, index, type.swigValue());
  }

  public int GetTextureCount(EffekseerTextureType type) {
    return EffekseerCoreJNI.EffekseerEffectCore_GetTextureCount(swigCPtr, this, type.swigValue());
  }

  public boolean LoadTexture(byte[] data, int len, int index, EffekseerTextureType type) {
    return EffekseerCoreJNI.EffekseerEffectCore_LoadTexture(swigCPtr, this, data, len, index, type.swigValue());
  }

  public String GetModelPath(int index) {
    return EffekseerCoreJNI.EffekseerEffectCore_GetModelPath(swigCPtr, this, index);
  }

  public int GetModelCount() {
    return EffekseerCoreJNI.EffekseerEffectCore_GetModelCount(swigCPtr, this);
  }

  public boolean LoadModel(byte[] data, int len, int index) {
    return EffekseerCoreJNI.EffekseerEffectCore_LoadModel(swigCPtr, this, data, len, index);
  }

}
