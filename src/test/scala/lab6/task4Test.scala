package lab6
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task4Test extends FreeSpec with ChiselScalatestTester{
  "Queue test" in {
    test(new task4){ c =>
        c.io.in.valid.poke(1.B)
        //c.io.in.ready.expect(1.B)
        c.io.in.bits.poke(2.U)
        //c.io.out.valid.expect(1.B)
        c.io.out.ready.poke(1.B)
        //c.io.out.bits.expect(0.U)
        c.clock.step(1)
    }
  }
}