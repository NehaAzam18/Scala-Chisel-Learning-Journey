package lab3
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester{
  "4_to_2_Encoder test" in {
    test(new task1()){ c =>
        c.io.in.poke("b0001".U)
        c.io.out.expect("b00".U)
        c.clock.step(1)
    }
  }
}