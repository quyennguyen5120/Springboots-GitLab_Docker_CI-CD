# Springboots-GitLab_Docker_CI-CD

https://www.devopshint.com/how-to-install-apache-maven-on-amazon-linux-2/

https://www.devopshint.com/how-to-install-gitlab-runner-on-amazon-linux-2/

================BEGIN================================
chmod 400 /Users/vudt/Desktop/AWS/kuuu.pem 
ssh ec2-user@44.201.139.58 -i /Users/vudt/Desktop/AWS/kuuu.pem 
sudo su -

===============install MariaDB================
	yum install mariadb-server
	systemctl enable mariadb 
	systemctl start mariadb 
	mysql_secure_installation
	mysql -u root -p
	tao database moi
	cai dat git tren aws
	down project ve
	==>vào thư mục mới clone về và gõ lệnh mysql -u root -p cy_notes < cy-notes.sql  ==> copy CSDL từ project vào mariaDB
	===> đăng nhập lại vào mariaDB và kiêmr tra xem dữ liệu oki chưa ?
	mvn package
	đổi tên DB và pass trong file properties

===============install Docker================
yum install docker
systemctl enable docker
systemctl start docker

===============Register gitlab-runner in VPS================
sudo gitlab-runner register --url htt://gitlab.com/ --registrantion -token <token code> ==> mã token lấy trong đường dẫn sau trong gitlab setting/CI_CD/run/token_code


sudo chmod 666 /var/run/docker.sock

===============Setting in Gitlab================
setting/CI-CD/variable ==> thêm 3 giá trị
	SERVER_USER,...
setting/CI_CD/runner ==> tắt "enable chared runner for this..."
setting/repository/ thêm tag live_*

===============Setting in EC2================
mở cổng trên AWS 9997 ==> cổng mà config trong file application.property trong spring
