module Mux_Tree(
  input        clock,
  input        reset,
  input  [3:0] io_in,
  input        io_s1,
  input        io_s2,
  input        io_s3,
  output       io_out
);
  wire  _io_out_T_4 = io_s1 ? io_in[1] : io_in[0]; // @[Main.scala 65:5]
  wire  _io_out_T_5 = io_s2 ? io_in[2] : _io_out_T_4; // @[Main.scala 64:47]
  assign io_out = io_s3 ? io_in[3] : _io_out_T_5; // @[Main.scala 64:17]
endmodule
