package lab5
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester{
  "ALU test" in {
    test(new ALU(32)){ c =>
        c.io.arg_x.poke(3.U)
        c.io.arg_y.poke(2.U)
        c.io.alu_oper.poke("b0000".U)
        c.io.alu_out.expect(2.U)
        c.clock.step(1)
    }
  }
}