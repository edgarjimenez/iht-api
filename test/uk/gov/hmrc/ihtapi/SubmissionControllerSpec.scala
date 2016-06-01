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

import play.api.test.FakeRequest
import play.api.test.Helpers._
import uk.gov.hmrc.play.test.{WithFakeApplication, UnitSpec}

class SubmissionControllerSpec extends UnitSpec with WithFakeApplication with Setup {

  "Submission controller" must {

    "respond to POST /iht-api/submission" in {
      val result = route(FakeRequest(POST, "/iht-api/submission"))
      status(result.get) shouldNot be(NOT_FOUND)
    }
  }

  "POST" must {

    "contain accept headers" in {
      val result = controller.post()(emptyRequest)
      status(result) shouldBe NOT_ACCEPTABLE
    }

    "with valid data" must {

      "respond with OK" in {
        val result = controller.post()(validRequest)
        status(result) shouldBe OK
      }
    }

    "with no data" must {

      "respond with Bad Request" in {
        val result = controller.post()(emptyRequestWithAcceptHeader)
        status(result) shouldBe BAD_REQUEST
      }
    }

    "with invalid data" must {

      "respond with Bad Request" in {
        val result = controller.post()(invalidRequest)
        status(result) shouldBe BAD_REQUEST
      }
    }
  }
}