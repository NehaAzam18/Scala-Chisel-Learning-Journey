package lab6
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester{
  "ShiftRegister test" in {
    test(new task1){ c =>
        c.io.in.poke("b1001".U)
        //c.io.out.expect(1.U)
        c.clock.step(20)
    }
  }
}