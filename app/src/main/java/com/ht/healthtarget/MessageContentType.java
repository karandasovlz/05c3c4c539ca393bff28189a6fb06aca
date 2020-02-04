package com.ht.healthtarget;

import android.support.annotation.Nullable;
//import com.example.chat.messages.MessageHolders;

/*
 * Created by troy379 on 28.03.17.
 */

/**
 * Interface used to mark messages as custom content types. For its representation see {@link MessageHolders}
 */

public interface MessageContentType extends IMessage {

    /**
     * Default media type for image message.
     */
    interface Image extends IMessage {
        @Nullable
        String getImageUrl();
    }

    // other default types will be here

}
