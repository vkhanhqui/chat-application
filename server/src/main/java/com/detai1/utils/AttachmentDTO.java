/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.utils;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author X507U-PC
 */
public class AttachmentDTO implements Serializable {

    private String message;
    private File file;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getMessage() {
        return message;
    }

    public File getFile() {
        return file;
    }

    public AttachmentDTO(String message, File file) {
        this.message = message;
        this.file = file;
    }

    public AttachmentDTO() {
        this.message = new String();
        this.file = null;
    }

}
