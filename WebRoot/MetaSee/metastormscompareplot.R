args<-commandArgs(T)
nba <- read.table(args[1], header=FALSE, sep="\t", strip.white=TRUE, blank.lines.skip=TRUE, allowEscapes=FALSE)
nba<-nba[c(0-ncol(nba))]
nba_matrix <- data.matrix(nba)
png("./metastormscompare.png");
nba_heatmap <- heatmap(nba_matrix, Rowv=NA, Colv=NA, col = cm.colors(256), margins=c(5,10))

