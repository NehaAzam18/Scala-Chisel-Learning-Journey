package lab5
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task6Test extends FreeSpec with ChiselScalatestTester{
  "Router test" in {
    test(new task6(UInt(32.W))){ c =>
        c.io.in.addr.poke(2.U)
        c.io.in.databit.poke(3.U)
        c.io.out.addr.expect(2.U)
        c.io.out.databit.expect(3.U)
        c.clock.step(1)
    }
  }
}