package lab5
import chisel3 . _
// class definition with function as parameter
class task3 [ T <: Data ]( n : Int , generic : T ) ( op : (T , T ) => T ) extends
Module {
require ( n > 0) // " reduce only works on non - empty Vecs "
val io = IO ( new Bundle {
val in = Input ( Vec (n , generic ) )
val out = Output (Vec (n , generic ))
})
io . out(0) := io.in.reduce(op)
io . out(1) := io.in.reduce(op)
}
