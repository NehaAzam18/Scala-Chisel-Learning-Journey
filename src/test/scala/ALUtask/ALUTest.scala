package ALUtask
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class ALUTest extends FreeSpec with ChiselScalatestTester{
  "ALU test" in {
    test(new ALU()){ c =>
        c.io.inputA.poke(4.S)
        c.io.inputB.poke(8.S)
        c.io.ALU_sel.poke("b1001".U)
        c.io.output.expect(1.S)
        c.clock.step(1)
    }
  }
}