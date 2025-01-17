/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.instrumentation.testing.junit.InstrumentationExtension;
import io.opentelemetry.instrumentation.testing.junit.http.HttpClientInstrumentationExtension;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.extension.RegisterExtension;

public class OkHttp3Test extends AbstractOkHttp3Test {

  @RegisterExtension
  static final InstrumentationExtension testing = HttpClientInstrumentationExtension.forLibrary();

  @Override
  public Call.Factory createCallFactory(OkHttpClient.Builder clientBuilder) {
    return OkHttpTelemetry.create(testing.getOpenTelemetry()).newCallFactory(clientBuilder.build());
  }
}
