module Mux_8to1(
  input        clock,
  input        reset,
  input  [7:0] io_in,
  input        io_s0,
  input        io_s1,
  input        io_s2,
  output       io_out
);
  wire  _Mux4_to_1_a_T_2 = io_s0 ? io_in[3] : io_in[2]; // @[Main.scala 45:39]
  wire  _Mux4_to_1_a_T_5 = io_s0 ? io_in[1] : io_in[0]; // @[Main.scala 46:5]
  wire  Mux4_to_1_a = io_s1 ? _Mux4_to_1_a_T_2 : _Mux4_to_1_a_T_5; // @[Main.scala 45:23]
  wire  _Mux4_to_1_b_T_2 = io_s0 ? io_in[7] : io_in[6]; // @[Main.scala 47:39]
  wire  _Mux4_to_1_b_T_5 = io_s0 ? io_in[5] : io_in[4]; // @[Main.scala 48:5]
  wire  Mux4_to_1_b = io_s1 ? _Mux4_to_1_b_T_2 : _Mux4_to_1_b_T_5; // @[Main.scala 47:23]
  assign io_out = io_s2 ? Mux4_to_1_b : Mux4_to_1_a; // @[Main.scala 49:21]
endmodule
