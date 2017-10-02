#!perl -w
use strict;
my $metaSeePath = $ARGV[0];
my $listPath = $ARGV[1];
chdir($listPath);
print "$listPath\n";
my $inputFile = $listPath . "metastormscompare\.txt";
my $command = "Rscript " . $metaSeePath . "metastormscompareplot.R " . $inputFile;
print "$command\n";
my $temp=`$command`;
