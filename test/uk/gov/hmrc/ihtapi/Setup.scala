/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.ihtapi

import play.api.libs.json.Json
import play.api.test.{FakeHeaders, FakeRequest}
import uk.gov.hmrc.ihtapi.controllers.ReturnSandboxController
import uk.gov.hmrc.ihtapi.models.DeceasedPersonDetails

trait Setup {

  val emptyRequest = FakeRequest(method = "POST", uri = "", headers = FakeHeaders(), body = Json.obj())

  val emptyRequestWithAcceptHeader = FakeRequest(method = "POST", uri = "", headers = FakeHeaders(
    Seq("Accept" -> Seq("application/vnd.hmrc.1.0+json"))), body = Json.obj())

  val controller = ReturnSandboxController

  val validDetails = DeceasedPersonDetails("Mr", "Smith", "John", "2016-01-01")

  val validRequest = FakeRequest(method = "POST", uri = "", headers = FakeHeaders(
    Seq("Content-type" -> Seq("application/json"),"Accept" -> Seq("application/vnd.hmrc.1.0+json"))), body = Json.toJson(validDetails))

  val invalidRequest = FakeRequest(method = "POST", uri = "", headers = FakeHeaders(
    Seq("Content-type" -> Seq("application/json"),"Accept" -> Seq("application/vnd.hmrc.1.0+json"))), body = Json.toJson("Invalid stuff"))
}
