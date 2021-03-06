#pragma once

#include "EffekseerBackendCore.h"

enum class EffekseerTextureType
{
	Color,
	Normal,
	Distortion,
};

class EffekseerEffectCore
{
private:
	Effekseer::Effect* effect_ = nullptr;

public:
	EffekseerEffectCore();
	~EffekseerEffectCore();

#if !defined(SWIGCSHARP)
	bool Load(char* data, int len, float magnification);
#endif

#if !defined(SWIGJAVA)
	bool Load(const unsigned char* data, int len, float magnification);
#endif

	const char16_t* GetTexturePath(int32_t index, EffekseerTextureType type) const;

	int32_t GetTextureCount(EffekseerTextureType type) const;

#if !defined(SWIGCSHARP)
	bool LoadTexture(char* data, int len, int32_t index, EffekseerTextureType type);
#endif

#if !defined(SWIGJAVA)
	bool LoadTexture(const unsigned char* data, int len, int32_t index, EffekseerTextureType type);
#endif

	bool HasTextureLoaded(int32_t index, EffekseerTextureType type);

	const char16_t* GetModelPath(int32_t index) const;

	int32_t GetModelCount() const;

#if !defined(SWIGCSHARP)
	bool LoadModel(char* data, int len, int32_t index);
#endif

#if !defined(SWIGJAVA)
	bool LoadModel(const unsigned char* data, int len, int32_t index);
#endif

	bool HasModelLoaded(int32_t index);

	const char16_t* GetMaterialPath(int32_t index) const;

	int32_t GetMaterialCount() const;

#if !defined(SWIGCSHARP)
	bool LoadMaterial(char* data, int len, int32_t index);
#endif

#if !defined(SWIGJAVA)
	bool LoadMaterial(const unsigned char* data, int len, int32_t index);
#endif

	bool HasMaterialLoaded(int32_t index);

	/**
	 * TODO : imeplement a funtions to load resources
	 * Plan
	 * Load -> only load effect binary
	 * Get internal path for resources and assign resouces
	 */

#if !defined(SWIG)
	Effekseer::Effect* GetInternal() const;
#endif
};