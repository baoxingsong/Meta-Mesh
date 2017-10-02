#!perl -w
use strict;
my $metaSeePath = $ARGV[0];
chdir($metaSeePath);
print "$metaSeePath\n";
my $listPath = $ARGV[1];
my $inputFile = $listPath . "list\.text";
open LIST,"$inputFile";
my $command = "java -jar " . $metaSeePath . "MetaSee.jar -i";
while(my $line=<LIST>){
	chomp($line);
	$line=~s/^\s*//;
	$line=~s/\s*$//;
	if(!$line=~/^\s*$/){
		$command = $command . " \"$line\"";
	}
}
close LIST;
$command = $command . " -o $listPath -f parallelmeta";
print "$command\n";
my $temp=`$command`;
