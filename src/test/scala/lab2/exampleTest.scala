package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class exampleTest extends FreeSpec with ChiselScalatestTester{
    "example Test" in {
        test(new example()){ c =>
        c.io.x.poke(3.U)
        c.io.y.poke(4.U)
        c.clock.step(1)
        c.io.sum.expect(7.U)
    }
}
}