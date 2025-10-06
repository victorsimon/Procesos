package com.example.procesos.application.util.validator;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.validation.ProcessValidator;
import com.example.procesos.domain.validation.exception.*;

public class ProcessSimpleValidatorImpl implements ProcessValidator {

    @Override
    public Process validate(Process process) throws InvalidProcessException {
        if (null == process)
            throw new InvalidProcessException();

        if (null == process.processId() || process.processId().isEmpty())
            throw new InvalidProcessIdException();

        if (null == process.name() || process.name().isEmpty())
            throw new InvalidProcessNameException();

        if (null == process.initDateTime())
            throw new InvalidProcessInitDateException();

        if (null == process.endDateTime())
            throw new InvalidProcessEndDateException();

        if (process.initDateTime().isAfter(process.endDateTime()))
            throw new InvalidProcessInitDateAfterEndDateException();

        return process;
    }

}
