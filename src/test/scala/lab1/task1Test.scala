package lab1
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester{
  "counterBit test" in {
    test(new task1(4.U)){ c =>
      c.clock.step(100)
    }
  }
}
