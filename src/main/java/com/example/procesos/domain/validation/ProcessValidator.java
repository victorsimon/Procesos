package com.example.procesos.domain.validation;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.validation.exception.InvalidProcessException;

public interface ProcessValidator {

    Process validate(Process process) throws InvalidProcessException;
}
