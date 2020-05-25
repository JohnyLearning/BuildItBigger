package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testBackgroundJoke() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void execute(String joke) {
                assertNotNull(joke);
                assertFalse(joke.startsWith("Failed"));
                signal.countDown();
            }
        }).execute(new Pair<Context, String>(activityTestRule.getActivity(), "Nobody"));
        signal.await();
    }

}
