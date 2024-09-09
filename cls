[1mdiff --git a/src/main/java/com/bloggingapp/exception/ResourceNotFoundException.java b/src/main/java/com/bloggingapp/exception/ResourceNotFoundException.java[m
[1mindex 7e4c7a5..7d347e2 100644[m
[1m--- a/src/main/java/com/bloggingapp/exception/ResourceNotFoundException.java[m
[1m+++ b/src/main/java/com/bloggingapp/exception/ResourceNotFoundException.java[m
[36m@@ -1,2 +1,27 @@[m
[31m-package com.bloggingapp.exception;public class ResourceNotFoundException {[m
[32m+[m[32mpackage com.bloggingapp.exception;[m
[32m+[m
[32m+[m[32mimport org.springframework.http.HttpStatus;[m
[32m+[m[32mimport org.springframework.web.bind.annotation.ResponseStatus;[m
[32m+[m
[32m+[m[32m@ResponseStatus(HttpStatus.NOT_FOUND)[m
[32m+[m[32mpublic class ResourceNotFoundException extends RuntimeException{[m
[32m+[m[32m    private long fieldValue;[m
[32m+[m[32m    private String resourceName;[m
[32m+[m[32m    private String fieldName;[m
[32m+[m[32m    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){[m
[32m+[m[32m        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));[m
[32m+[m[32m        this.fieldName=fieldName;[m
[32m+[m[32m        this.resourceName=resourceName;[m
[32m+[m[32m        this.fieldValue=fieldValue;[m
[32m+[m[32m    }[m
[32m+[m[32m    public long getFieldValue(){[m
[32m+[m[32m        return this.fieldValue;[m
[32m+[m[32m    }[m
[32m+[m[32m    public String getResourceName(){[m
[32m+[m[32m        return this.resourceName;[m
[32m+[m[32m    }[m
[32m+[m[32m    public String getFieldName(){[m
[32m+[m[32m        return this.fieldName;[m
[32m+[m[32m    }[m
[32m+[m
 }[m
