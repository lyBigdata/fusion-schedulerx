/*
 * Copyright 2019 akka-fusion.com
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

package fusion.schedulerx.server.repository

import java.time.OffsetDateTime

import akka.actor.typed.ActorSystem
import com.zaxxer.hikari.HikariDataSource
import fusion.jdbc.FusionJdbc
import fusion.schedulerx.job.ProcessResult
import fusion.schedulerx.protocol._
import fusion.schedulerx.server.model.JobConfigInfo
import fusion.schedulerx.server.protocol.BrokerInfoData

// 数据存储访问
class BrokerRepository(dataSource: HikariDataSource) {
  def disableJobInfo(in: DisableJobRequest): Int = ???

  def enableJobInfo(in: EnableJobRequest): Int = ???

  def deleteJobInfo(in: DeleteJobRequest): Int = ???

  def getJobInfo(in: GetJobInfoRequest): Option[JobConfigInfo] = ???

  def listBroker(): Seq[BrokerInfoData] = {
    List(BrokerInfoData("default", "default"))
  }

  def completeJobInstance(instanceId: String, result: ProcessResult) = ???
  def updateJobInstance(instanceId: String, status: Int, startTime: Option[OffsetDateTime]) = ???
  def saveJobInstance(jobInstanceData: JobInstanceDetail) = ???
}

object BrokerRepository {
  def apply(system: ActorSystem[_]): BrokerRepository = new BrokerRepository(FusionJdbc(system).components.component)
}
