set terminal pdfcairo enhanced color size 29cm,21cm font "Times-New-Roman" fontscale .6
set xrange[10:1e6]
set output "LargeNumber.pdf"
set title "Law of Large Numbers"
set multiplot layout 2,1
set tmargin 3
set bmargin 1 
set lmargin 15
set log x
unset xtics
set ylabel "average"
set yrange [.496:0.504]
set format x "10^{%L}"
f(x)=0.5
plot "output.txt" ps 2 pt 7 title "simulation",\
f(x) lw 3 title "theory"
#
unset title
#set title "Law of Large Numbers (variance)"
#set output "LargeNumberVariance.pdf"
set tmargin 1
set bmargin 3 
set xtics
set ylabel "standard deviation"
set xlabel "sample size"
set yrange [*:*]
set log xy
set format y "10^{%L}"
f(x) = sqrt(1./12/x)
plot "output.txt" u 1:3 ps 2 pt 7 title "simulation",\
f(x) lw 3 title "theory"