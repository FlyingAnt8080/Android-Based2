package com.suse.beatbox;

public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath) {
        this.mAssetPath = mAssetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length-1];
        mName = filename.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
