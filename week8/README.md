# 8주차 학습 내용 (CRUD API 연습)

## 이론(공부해서 각 항목 아래에 작성해주세요!)
- REST API
- REST API 설계 주의 점(동사를 써도 되는 경우)
- HTTP 특징
- HTTP 메소드 8가지
- DB
  - 정규화 3단계
  - 1 : 1
  - 1 : M
  - M : M
  - PK, FK

## 1. **User 엔터티 관련 API**(실습)

### 1.1 회원 가입

- **URL**:
- **설명**: 새로운 사용자를 등록합니다.
- **Request Body**:
    
    ```json
    
    {
      "username": "john_doe",
      "email": "john@example.com",
      "password": "password123"
    }
    
    ```
    

### 1.2 사용자 정보 조회

- **URL**:
- **설명**: 특정 사용자 정보를 조회합니다.
- **Response 예시**:
    
    ```json
    
    {
      "id": 1,
      "username": "john_doe",
      "email": "john@example.com"
    }
    
    ```
    

### 1.3 사용자 정보 업데이트

- **URL**:
- **설명**: 특정 사용자의 프로필 정보를 업데이트합니다.
- **Request Body**:
    
    ```json
    
    {
      "username": "john_doe_updated",
      "email": "new_email@example.com"
    }
    
    ```
    

### 1.4 사용자 삭제

- **URL**:
- **설명**: 특정 사용자를 삭제합니다.

---

## 2. **Post 엔터티 관련 API**

### 2.1 게시글 작성(과제)

- **URL**:
- **설명**: 새로운 게시글을 작성합니다.
- **Request Body**:
    
    ```json
    
    {
      "title": "My First Post",
      "content": "This is the content of the post.",
      "userId": 1
    }
    
    ```
    

### 2.2 게시글 목록 조회

- **URL**:
- **설명**: 모든 게시글 목록을 조회합니다.
- **Response 예시**:
    
    ```json
    
    [
      {
        "id": 1,
        "title": "My First Post",
        "content": "This is the content of the post.",
        "userId": 1
      },
      {
        "id": 2,
        "title": "Another Post",
        "content": "Some other content.",
        "userId": 2
      }
    ]
    
    ```
    

### 2.3 특정 게시글 조회

- **URL**:
- **설명**: 특정 게시글을 조회합니다.
- **Response 예시**:
    
    ```json
    
    {
      "id": 1,
      "title": "My First Post",
      "content": "This is the content of the post.",
      "userId": 1
    }
    
    ```
    

### 2.4 게시글 수정

- **URL**:
- **설명**: 특정 게시글의 내용을 수정합니다.
- **Request Body**:
    
    ```json
    
    {
      "title": "Updated Title",
      "content": "Updated content"
    }
    
    ```
    

### 2.5 게시글 삭제

- **URL**:
- **설명**: 특정 게시글을 삭제합니다.

---

## 3. **Comment 엔터티 관련 API**(과제)

### 3.1 댓글 작성

- **URL**:
- **설명**: 특정 게시글에 댓글을 작성합니다.
- **Request Body**:
    
    ```json
    
    {
      "content": "This is a comment.",
      "userId": 1
    }
    
    ```
    

### 3.2 특정 게시글의 댓글 목록 조회

- **URL**:
- **설명**: 특정 게시글에 달린 모든 댓글을 조회합니다.
- **Response 예시**:
    
    ```json
    
    [
      {
        "id": 1,
        "content": "This is a comment.",
        "userId": 1,
        "postId": 1
      },
      {
        "id": 2,
        "content": "Another comment.",
        "userId": 2,
        "postId": 1
      }
    ]
    
    ```
    

### 3.3 댓글 수정

- **URL**:
- **설명**: 특정 댓글을 수정합니다.
- **Request Body**:
    
    ```json
    
    {
      "content": "Updated comment content"
    }
    
    ```
    

### 3.4 댓글 삭제

- **URL**:
- **설명**: 특정 댓글을 삭제합니다.

## 4. **추가 기능 API**(선택 과제)

### 4.1 특정 사용자의 게시글 목록 조회

- **URL**: `GET /api/users/{userId}/posts`
- **설명**: 특정 사용자가 작성한 모든 게시글을 조회합니다

### 4.2 특정 사용자의 댓글 목록 조회

- **URL**:
- **설명**: 특정 사용자가 작성한 모든 게시글을 조회합니다
