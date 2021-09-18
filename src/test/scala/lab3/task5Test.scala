package lab3
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task5Test extends FreeSpec with ChiselScalatestTester{
  "4_to_2_Decoder test" in {
    test(new task5()){ c =>
        c.io.in.poke("b01".U)
        c.io.out.bits.expect("b0010".U)
        c.io.out.valid.expect(1.B)
        c.clock.step(1)
    }
  }
}