package uk.co.datumedge.redislauncher.maven;

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.co.datumedge.redislauncher.RedisServer;

@RunWith(JMock.class)
public class LocalRedisServerStarterMojoTest {
	private final Mockery context = new JUnit4Mockery();
	private final RedisServer redisServer = context.mock(RedisServer.class);
	private final LocalRedisServerStarterMojo mojo = new LocalRedisServerStarterMojo();

	public LocalRedisServerStarterMojoTest() {
		mojo.setRedisServer(redisServer);
	}

	@Test
	public void startsLocalRedisServer() throws MojoExecutionException, MojoFailureException, IOException, InterruptedException {
		context.checking(new Expectations() {{
			oneOf(redisServer).start();
		}});

		mojo.execute();
	}

	@Test(expected=MojoExecutionException.class)
	public void throwsMojoExecutionExceptionWhenRedisServerThrowsIOException() throws MojoExecutionException, MojoFailureException, IOException, InterruptedException {
		context.checking(new Expectations() {{
			oneOf(redisServer).start(); will(throwException(new IOException()));
		}});

		mojo.execute();
	}

	@Test(expected=MojoExecutionException.class)
	public void throwsMojoExecutionExceptionWhenRedisServerThrowsInterruptedException() throws MojoExecutionException, MojoFailureException, IOException, InterruptedException {
		context.checking(new Expectations() {{
			oneOf(redisServer).start(); will(throwException(new InterruptedException()));
		}});

		mojo.execute();
	}
}
