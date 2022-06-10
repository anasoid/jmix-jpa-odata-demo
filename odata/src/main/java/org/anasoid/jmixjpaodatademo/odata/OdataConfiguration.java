package org.anasoid.jmixjpaodatademo.odata;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("org.anasoid.jmixjpaodatademo.core.entity")
public class OdataConfiguration {
}
