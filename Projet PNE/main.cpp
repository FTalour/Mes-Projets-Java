#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <stdlib.h>

void buildSVG(const std::string& pathToImagePrev,const std::string& pathToImageNext, const std::vector<std::pair<int,int> >& prevPoints,const std::vector<std::pair<int,int> >& nextPoints, const double Txx,const double Txy, const double Tyx, const double Tyy, const double tx, const double ty){
	std::vector<std::pair<int,int> > estimedPoints(prevPoints.size());
	for(int i=0;i<(int)estimedPoints.size();i++){
		estimedPoints[i].first  = tx + Txx*prevPoints[i].first + Txy*prevPoints[i].second;
		estimedPoints[i].second = ty + Tyx*prevPoints[i].first + Tyy*prevPoints[i].second;
	}
	
	std::ofstream svg("output.svg");
	svg << "<?xml version=\"1.0\" standalone=\"no\"?>\n";
	svg << "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n";
	svg << "<svg height=\"476px\" width=\"1404px\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink= \"http://www.w3.org/1999/xlink\">\n";
	svg << "\t<image xlink:href=\"" << pathToImagePrev <<"\" x=\"0px\" height=\"476px\" width=\"702px\"/>\n";
	svg << "\t<image xlink:href=\"" << pathToImageNext <<"\" x=\"702px\" height=\"476px\" width=\"702px\"/>\n";
	
	for(int i=0;i<(int)estimedPoints.size();i++){
		svg << "\t<circle cx=\""<< prevPoints[i].first <<"\" cy=\""<< prevPoints[i].second <<"\" r=\"3\" fill=\"blue\"/>\n";
		svg << "\t<circle cx=\""<< nextPoints[i].first+702 <<"\" cy=\""<< nextPoints[i].second <<"\" r=\"3\" fill=\"blue\"/>\n";
		svg << "\t<circle cx=\""<< prevPoints[i].first+702 <<"\" cy=\""<< prevPoints[i].second <<"\" r=\"3\" fill=\"yellow\"/>\n";
		svg << "\t<circle cx=\""<< estimedPoints[i].first+702 <<"\" cy=\""<< estimedPoints[i].second <<"\" r=\"3\" fill=\"green\"/>\n";
	}
	svg << "</svg>\n";
}

std::vector<std::pair<int,int> > loadPoints(const std::string& pathToPoints){
	std::ifstream file(pathToPoints.c_str());
	int token;
	file >> token;
	std::vector<std::pair<int,int> > points(token);
	for(int i=0;i<(int)points.size();i++)
		file >> points[i].first >> points[i].second;
	return points;
}

int main(int argc,char **argv){
	///////////////////////////////
	//TODO change the value here
	const double Txx = 1.00889;
	const double Tyx = -0.00889188;
	const double Txy = 0.00407545;
	const double Tyy = 0.995925;
	const double  tx = -1.94715;
	const double  ty = 0.947154;
	//TODO change the value here
	///////////////////////////////
	
	const std::string pathToImagePrev = "prev.jpg";
	const std::string pathToImageNext = "next.jpg"; 
	const std::string pathToPrevPoints = "prev.txt";
	const std::string pathToNextPoints = "next.txt";
	buildSVG(pathToImagePrev,pathToImageNext,loadPoints(pathToPrevPoints),loadPoints(pathToNextPoints),Txx,Txy,Tyx,Tyy,tx,ty);
	return 0;
}
