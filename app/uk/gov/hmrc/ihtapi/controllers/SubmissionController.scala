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

package uk.gov.hmrc.ihtapi.controllers

import uk.gov.hmrc.api.controllers.HeaderValidator
import uk.gov.hmrc.ihtapi.models.DeceasedPersonDetails
import uk.gov.hmrc.play.microservice.controller.BaseController

import scala.concurrent.Future

trait SubmissionController extends BaseController with HeaderValidator {

  def post() = validateAccept(acceptHeaderValidationRules).async(parse.json) {
        println("Woohoo")
    implicit request =>
      withJsonBody[DeceasedPersonDetails] { deceasedPersonDetails =>
        Future.successful(Ok)
      }
  }
}

object SandboxSubmissionController extends SubmissionController {

}
