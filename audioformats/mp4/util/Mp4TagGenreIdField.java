/*
 * Entagged Audio Tag library
 * Copyright (c) 2003-2005 Raphael Slinckx <raphael@slinckx.net>
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *  
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package entagged.audioformats.mp4.util;

import entagged.audioformats.Tag;
import entagged.audioformats.generic.Utils;

import java.io.UnsupportedEncodingException;

public class Mp4TagGenreIdField extends Mp4TagTextField {
    
    public Mp4TagGenreIdField(String id, String n) {
        super(id, n);
    }

    public Mp4TagGenreIdField(String id, byte[] raw) throws UnsupportedEncodingException {
        super(id, raw);
    }
    
    protected byte[] getDataBytes() {
        return Utils.getSizeBigEndian(Integer.parseInt(content));
    }
    
    protected void build(byte[] raw) throws UnsupportedEncodingException {
        int genreId = raw[raw.length - 1];
        this.content = (genreId < Tag.DEFAULT_GENRES.length) ? Tag.DEFAULT_GENRES[genreId] : "";
    }
}
