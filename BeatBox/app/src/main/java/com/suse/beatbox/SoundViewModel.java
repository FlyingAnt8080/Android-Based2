package com.suse.beatbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SoundViewModel extends BaseObservable {
    private Sound sound;
    private BeatBox beatBox;

    public SoundViewModel(BeatBox beatBox) {
        this.beatBox = beatBox;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle(){
        return sound.getName();
    }
}
