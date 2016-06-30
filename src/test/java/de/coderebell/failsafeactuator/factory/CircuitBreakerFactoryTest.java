/**
 * The MIT License (MIT)
 * Copyright (c) 2016 Malte Pickhan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.coderebell.failsafeactuator.factory;

import de.coderebell.failsafeactuator.FailsafeSampleApp;
import de.coderebell.failsafeactuator.service.CircuitBreakerFactory;
import net.jodah.failsafe.CircuitBreaker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(value = "classpath:application-test.properties")
@SpringApplicationConfiguration(classes = FailsafeSampleApp.class)
public class CircuitBreakerFactoryTest {

    @Autowired
    private CircuitBreakerFactory factory;

    @Test
    public void instanceUnequalTest() {
        final CircuitBreaker breakerOne = factory.createCircuitBreaker("ONE");

        final CircuitBreaker breakerTwo = factory.createCircuitBreaker("TWO");

        Assert.assertNotEquals(breakerOne, breakerTwo);
    }

}