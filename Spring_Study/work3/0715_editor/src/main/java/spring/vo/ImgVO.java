package spring.vo;

import org.springframework.web.multipart.MultipartFile;

public class ImgVO {
	//�Ķ���Ϳ� �̸��� ���� �ɹ����� ����
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
