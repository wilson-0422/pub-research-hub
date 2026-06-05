
# 研究协作平台

一个面向科研团队的研究协作平台，支持论文管理、实验记录、项目追踪与团队协作。

## 适用场景

- 高校科研团队管理
- 实验室研究项目管理
- 论文协作与追踪
- 跨机构研究协作

## 核心功能

1. **论文管理**
   - 论文信息录入
   - DOI 关联
   - 论文状态追踪（草稿/已提交/已发表）
   - 关键词与期刊管理

2. **实验记录**
   - 实验假设记录
   - 方法学描述
   - 结果与结论记录
   - 实验状态追踪

3. **项目管理**
   - 研究项目创建
   - 项目周期管理
   - 团队关联

4. **团队协作**
   - 团队创建与管理
   - 研究领域标注
   - 成员角色管理

5. **笔记系统**
   - 研究笔记记录
   - 项目关联笔记

## 技术栈

- **语言**: Java 21
- **框架**: Spring Boot 3.2
- **数据库**: H2
- **模板引擎**: Thymeleaf
- **安全**: Spring Security + BCrypt

## 目录结构

```
src/main/java/com/researchhub/
├── ResearchHubApplication.java
├── config/              # 安全与Web配置
├── controller/          # 控制器
├── model/               # 数据模型
├── repository/          # 数据访问层
├── service/             # 业务服务层
└── dto/                 # 数据传输对象
src/main/resources/
├── application.properties
├── data.sql             # 初始化数据
├── schema.sql           # 数据库结构
└── templates/           # 页面模板
```

## Docker 启动方式

```bash
docker build -t pub-research-hub .
docker run -p 8080:8080 pub-research-hub
```

## 本地启动方式

```bash
mvn spring-boot:run
```

## 默认账号

- 用户名: admin / 邮箱: admin@example.com / 密码: admin123
- 用户名: researcher1 / 邮箱: researcher@example.com / 密码: research123
- 用户名: leader1 / 邮箱: leader@example.com / 密码: leader123

## 可扩展方向

1. 文献引用管理
2. 实验数据可视化
3. 论文全文检索
4. 学术社交功能
5. 研究成果统计报告
6. 与学术数据库API对接
