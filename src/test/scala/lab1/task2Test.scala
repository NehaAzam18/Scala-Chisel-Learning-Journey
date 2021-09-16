package lab1
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester{
  "test only" in {
    test(new task2(4.U)){ c =>
      c.clock.step(100)
    }
  }
}
