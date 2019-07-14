package com.lux.calculator.listener;

import com.lux.calculator.event.MathOperationEvent;

/**
 * This listener listen to math model change
 * 
 * @author Oleksandr K
 *
 */
public interface MathModelChangeListener {

    void update(MathOperationEvent event);

}
