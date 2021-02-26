package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ description:
 * @ Author: Ezio Liu
 * @ Date: 2021/2/26 1:39 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String message;
}