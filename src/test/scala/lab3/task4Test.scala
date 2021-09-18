package lab3
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task4Test extends FreeSpec with ChiselScalatestTester{
  "ImmdValGen test" in {
    test(new task4()){ c =>
        c.io.instr.poke("h00800513".U)
        c.io.immd_sel.expect(8.U)
        c.clock.step(1)
    }
  }
}