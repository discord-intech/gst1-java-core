/* 
 * Copyright (c) 2015 Neil C Smith
 * Copyright (c) 2014 Tom Greenwood <tgreenwood@cafex.com>
 * Copyright (c) 2007, 2008 Wayne Meissner
 * Copyright (C) 2004 Wim Taymans <wim@fluendo.com>
 * 
 * This file is part of gstreamer-java.
 *
 * This code is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU Lesser General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License 
 * version 3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.freedesktop.gstreamer;

import static org.freedesktop.gstreamer.lowlevel.GstSampleAPI.GSTMESSAGE_API;

/**
 * Lightweight objects to signal the occurrence of pipeline events.
 * 
 * <p> Messages are implemented as a subclass of {@link MiniObject} with a generic
 * {@link Structure} as the content. This allows for writing custom messages without
 * requiring an API change while allowing a wide range of different types
 * of messages.
 *
 * <p> Messages are posted by objects in the pipeline and are passed to the
 * application using the {@link Bus}.

 * The basic use pattern of posting a message on a Bus is as follows:
 *
 * <example>
 * <title>Posting a Message</title>
 *   <code>
 *    bus.post(new EOSMessage(source));
 *   </code>
 * </example>
 *
 * An {@link Element} usually posts messages on the bus provided by the parent
 * container using {@link Element#postMessage postMessage()}.
 */
public class Sample extends MiniObject {
    public static final String GTYPE_NAME = "GstSample";

    /**
     * Creates a new instance of Message.
     * 
     * @param init internal initialization data.
     */
    public Sample(Initializer init) {
        super(init);
    }
    
    public Caps getCaps() {
        return GSTMESSAGE_API.gst_sample_get_caps(this);
    }
    
    /**
     * Gets the buffer
     * 
     * @return the buffer
     */
    public Buffer getBuffer() {
//         Pointer ptr = gst.gst_sample_get_buffer(this);
//         
//         // Buffer is owned alongside sample - freeing sample
//         // will unref the buffer so add another ref
//         return new Buffer(new Initializer(ptr, true, true));
        return GSTMESSAGE_API.gst_sample_get_buffer(this);
    }
    
}
