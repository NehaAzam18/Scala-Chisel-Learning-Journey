package lab1
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class assignmentTest extends FreeSpec with ChiselScalatestTester{
  "counterBit test" in {
    test(new assignment(3)){ c =>
      c.io.data_in.poke(5.U)
      c.clock.step(100)
    }
  }
}
