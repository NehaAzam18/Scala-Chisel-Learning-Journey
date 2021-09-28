package lab5
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task3Test extends FreeSpec with ChiselScalatestTester{
  "operatorOperation test" in {
    test(new task3(2 , UInt(16. W ))( _ + _ ) ) { c =>
        c.io.in(0).poke( 2.U)
        c.io.in(1).poke( 2.U)
        //c.io.in2.poke(1.S)
        c.io.out(0).expect(4.U)
        c.io.out(1).expect(4.U)
        c.clock.step(1)
    }
  }
}