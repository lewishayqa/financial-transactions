/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package config

import javax.inject.{Inject, Singleton}

import play.api.Mode.Mode
import play.api.{Configuration, Environment}
import uk.gov.hmrc.play.config.ServicesConfig

@Singleton
class MicroserviceAppConfig @Inject()(val environment: Environment, val conf: Configuration) extends ServicesConfig {

  override protected def runModeConfiguration: Configuration = conf
  override protected def mode: Mode = environment.mode

  lazy val appName: String = getString("appName")

  lazy val desEnvironment: String = getString("microservice.services.des.environment")
  lazy val desToken: String = getString("microservice.services.des.auth-token")
  lazy val desUrl: String = getString("microservice.services.des.url")

}
