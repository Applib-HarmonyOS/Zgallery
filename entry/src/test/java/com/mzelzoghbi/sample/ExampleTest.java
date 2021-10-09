package com.mzelzoghbi.sample;

import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    @Test
    public void onStart() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.mzelzoghbi.sample", actualBundleName);
    }
}
