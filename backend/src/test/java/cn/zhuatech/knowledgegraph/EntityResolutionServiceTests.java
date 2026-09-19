/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.knowledgegraph;import cn.zhuatech.knowledgegraph.service.EntityResolutionService;import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.assertj.core.api.Assertions.assertThat;
class EntityResolutionServiceTests{private final EntityResolutionService s=new EntityResolutionService();
 @Test void mergesStrongIdentityEvidence(){var r=s.resolve(req("ORG","ORG","A","A","0.95",2,false,80,false));assertThat(r.decision()).isEqualTo(EntityResolutionService.Decision.MERGE);}
 @Test void reviewsAmbiguousEntity(){var r=s.resolve(req("ORG","ORG","","","0.75",1,false,80,false));assertThat(r.decision()).isEqualTo(EntityResolutionService.Decision.REVIEW);}
 @Test void keepsConflictingEntitiesSeparate(){var r=s.resolve(req("PERSON","ORG","A","A","1",3,true,50,true));assertThat(r.decision()).isEqualTo(EntityResolutionService.Decision.KEEP_SEPARATE);assertThat(r.conflicts()).hasSize(2);}
 private EntityResolutionService.Request req(String lt,String rt,String li,String ri,String sim,int sources,boolean conflict,int threshold,boolean approved){return new EntityResolutionService.Request("L","R",lt,rt,li,ri,new BigDecimal(sim),sources,conflict,threshold,approved);}}
